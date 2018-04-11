package stefan.DBconnectiondeployment.establishConnection;

import com.jcraft.jsch.*;

public class Launch {
	private static Session session;

	public static void SSHConnect() {
		System.out.println("POCNUVAM");
		//The starting point, used to create sessions and manage identities.
		JSch jsch = new JSch();
		try {
			jsch.addIdentity("/home/pi/Schreibtisch/pps06.ppk");
			//oracle : login, pps03... : ip , 24226 : port
			session = jsch.getSession("oracle", "pps03.hs-el.de", 24226);
			//ajout d'une config a la session
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			
			
			session.connect();
			//Le tunnel ssh utilisé ordre : source port , ip , port
			session.setPortForwardingL(1563, "127.0.0.1", 1521);
			System.out.println("Succeed...");

		} catch (JSchException e) {
			e.printStackTrace();
		}
	}

	public static int SSHDisconnet() {
		System.out.println("Disconnected...");
		session.disconnect();
		return 0;
	}
}
