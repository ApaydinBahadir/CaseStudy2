package src.command.StokKartList;

import javax.swing.JOptionPane;

import src.command.Command;
import src.util.JasperUtil;
import src.util.MailUtil;
import src.view.StokKartListView;

public class StokKartListMailCommand implements Command {
	StokKartListView frame;

	
	public StokKartListMailCommand(StokKartListView frame) {
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
