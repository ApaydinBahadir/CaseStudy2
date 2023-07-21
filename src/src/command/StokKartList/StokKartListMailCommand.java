package src.command.StokKartList;

import javax.swing.JOptionPane;

import src.command.Command;
import src.util.JasperUtil;
import src.util.MailUtil;
import src.view.StokKartList;

public class StokKartListMailCommand implements Command {
	StokKartList frame;

	
	public StokKartListMailCommand(StokKartList frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		sendMail();
	}

	private void sendMail() {
		String getMail = JOptionPane.showInputDialog(frame, "Lütfen gönderilecek eposta adresini giriniz:");
		JasperUtil.getPDF();
		MailUtil.sendMail(getMail);
	}
}
