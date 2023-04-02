package at.paulh;

public class Main {

	private static String name = "Paul";
	private static int age = 28;
	public static void main(String[] args) throws ClassNotFoundException {
		MySQL.connect();
		
		MySQL.update("INSERT INTO `user`(`Name`, `Age`) VALUES ('" + name + "','" + age + "')");
		MySQL.disconnect();

	}

}
