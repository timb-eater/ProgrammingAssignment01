package org.example;

public class SoftwareTicket extends Ticket {
    private final String system;         // e.g., "Email", "LMS", "VPN"
    private final boolean securityIssue;  // true if security-related
    private final boolean affectsLogin;   // true if blocks login

    public SoftwareTicket(int id, String requester, int priority, int daysOpen,
                          String system, boolean securityIssue, boolean affectsLogin) {
        super(id, requester, priority, daysOpen);
        this.system = system;
        this.securityIssue = securityIssue;
        this.affectsLogin = affectsLogin;
    }

    public String getSystem() { return system; }
    public boolean isSecurityIssue() { return securityIssue; }
    public boolean isAffectsLogin() { return affectsLogin; }

    // -----------------------------------------
    // xTODO #3 (Inheritance)
    // Implement urgencyScore() for software tickets.
    // Suggested scoring:
    //   score = priority*10 + daysOpen
    //   + (securityIssue ? 25 : 0)
    //   + (affectsLogin ? 15 : 0)
    //   + (system equalsIgnoreCase "VPN" ? 8 : 0)
    // Return the final score.
    // -----------------------------------------
    @Override
    public int urgencyScore() {
        // xTODO #3
        return (getPriority() * 10) + getDaysOpen()
                + (isSecurityIssue() ? 25: 0)
                + (isAffectsLogin() ? 15 : 0)
                + (getSystem().equals("VPN") ? 8 : 0);
    }
}