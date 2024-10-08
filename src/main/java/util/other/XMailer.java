package util.other;

import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

/**
 * Lớp tiện ích cung cấp các phương thức gửi email qua Google Mail
 * @author NghiemN
 * @version 1.0
 */
public class XMailer {
	private static Properties props = new Properties();
	static {
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.host.starttls.enable", "true");
	}
	private static Session getSession() {
		return Session.getDefaultInstance(props , new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				String username = "user@gmail.com";
				String password = "<appkey>";
				return new PasswordAuthentication(username, password);
			}
		});
	}
	/**
	 * Gửi email
	 * @param mail đối tượng chứa dữ liệu email
	 * @exception lỗi gửi mail
	 */
	public static void send(MailData mail) {
		Session session = XMailer.getSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(mail.getFrom()));
			message.setRecipients(RecipientType.TO, mail.getTo());
			message.setRecipients(RecipientType.CC, mail.getCc());
			message.setRecipients(RecipientType.BCC, mail.getBcc());
			message.setSubject(mail.getSubject(), "utf-8");
			message.setText(mail.getBody(), "utf-8", "html");
			message.setReplyTo(message.getFrom());
			String filenames = mail.getFilenames();
			if(filenames != null && filenames.trim().length() > 0) {
				Multipart attachs = new MimeMultipart();
				for(String filename: filenames.split("[,;]+")) {
					MimeBodyPart bodyPart = new MimeBodyPart();
					try {
						bodyPart.attachFile(filename.trim());
						attachs.addBodyPart(bodyPart);
					} catch (Exception e) {
						System.out.println("Attach error: " + filename);
					}
				}
				message.setContent(attachs);
			}
			Transport.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * Gửi email đơn giản
	 * @param to email người nhận
	 * @param subject tiêu đề mail
	 * @param body nội dung mail
	 * @exception lỗi gửi mail
	 */
	public static void send(String to, String subject, String body) {
		XMailer.send(new MailData(to, subject, body));
	}
	/**
	 * Mô tả dữ liệu mail
	 * @author NghiemN
	 * @version 1.0
	 */
	public static class MailData{
		String from = "Solo2K <solo2K@gmail.com>";
		String to;
		String cc;
		String bcc;
		String subject;
		String body;
		String filenames;
		/**
		 * Tạo đối tượng với 3 thuộc tính đơn giản
		 * @param to email người nhận
		 * @param subject tiên đề mail
		 * @param body nội dung email
		 */
		public MailData(String to, String subject, String body) {
			this(to, subject, body, Map.of());
		}
		/**
		 * Tạo đối tượng với 3 thuộc tính đơn giản và các thuộc tính tùy chọn
		 * @param to email người nhận
		 * @param subject tiên đề mail
		 * @param body nội dung email
		 * @param others các thuộc tính bổ sung (from, cc, bcc, filenames)
		 */
		public MailData(String to, String subject, String body, Map<String, String> others) {
			this.to = to;
			this.subject = subject;
			this.body = body;
			this.from = others.get("from");
			this.cc = others.get("cc");
			this.bcc = others.get("bcc");
			this.filenames = others.get("filenames");
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		public String getCc() {
			return cc;
		}

		public void setCc(String cc) {
			this.cc = cc;
		}

		public String getBcc() {
			return bcc;
		}

		public void setBcc(String bcc) {
			this.bcc = bcc;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		public String getFilenames() {
			return filenames;
		}

		public void setFilenames(String filenames) {
			this.filenames = filenames;
		}
	}
}