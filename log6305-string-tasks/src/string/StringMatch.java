package string;

public class StringMatch {

	public static void main(java.lang.String[] args) {
		StringMatch stringMatch = new StringMatch();

		stringMatch.method(args[0]);

	}

	public void method(String str) {
		if ("R2d!".equals(str)) {
			System.out.println("Got it!");
		}else{
			System.out.println("It's something else.");
		}
	}

}
