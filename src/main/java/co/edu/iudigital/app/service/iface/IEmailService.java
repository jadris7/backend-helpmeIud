package co.edu.iudigital.app.service.iface;

public interface IEmailService {

	public boolean sendEmail(String message, String to, String subject);
}
