package Bundle;
import java.util.Locale;
import java.util.ResourceBundle;
public class RsBundle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle rbun=ResourceBundle.getBundle("test",Locale.ENGLISH);
		String uid=rbun.getString("userid");
		String pwd=rbun.getString("pass");
		if((uid.equals("root")) && (pwd.equals("root"))){
				System.out.println("Welcome"+ uid);
		}
		else {
			System.out.println("Incorrect User....");
		}
	}

}
