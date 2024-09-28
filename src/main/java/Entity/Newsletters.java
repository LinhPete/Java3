package Entity;

public class Newsletters {
    private String email;
    private boolean enabled; // true = still valid

    public Newsletters(String email, boolean enabled) {
        this.email = email;
        this.enabled = enabled;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

