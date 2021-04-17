package example.custom.constraint.validator.example3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractWebsiteUrlDetails {

	public static String extractSubDomain(String url) {
		String origin = extractUrlOrigin(url);
		return origin.replace("https://", "")
			.replace("http://", "").split("[.]")[1];
	}

	public static String extractUrlProtocol(String url) {
		String protocol = "";
		if (url.toLowerCase().startsWith("https://")) {
			protocol = "https:";
		} else if (url.toLowerCase().startsWith("http://")) {
			protocol = "http:";
		}
		return protocol;
	}

	public static String extractUrlOrigin(String url) {
		String[] pathArray = url.split("/");
		String protocol = pathArray[0];
		String host = pathArray[2];
		String origin = protocol + "//" + host;

		int qIndex = origin.indexOf('?');

		if (qIndex != -1) {
			origin = origin.substring(0, qIndex);
		}

		return origin;
	}

	public static boolean isValidWebsite(String url) {
		Pattern p = Pattern.compile("((http|https)://)(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)");
		Matcher m = p.matcher(url);

		return m.find();
	}
}
