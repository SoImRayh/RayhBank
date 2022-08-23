package ifg.edu.rayhbank.service;

import ifg.edu.rayhbank.domain.NotificationEmail;

public interface MailService {
    void sendMail(NotificationEmail notificationEmail);
}
