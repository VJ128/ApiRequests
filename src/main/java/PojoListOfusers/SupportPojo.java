package PojoListOfusers;

public class SupportPojo {
	private String url;
	private String text;
	SupportPojo(){}
	public SupportPojo(String url, String text) {
		this.url = url;
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "SupportPojo {url=" + url + ", text=" + text + "}";
	}


}
