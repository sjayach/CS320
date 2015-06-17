package quotation;

public class QuotationBean {
	int id;
	String author;
	String quotes;
	
	public QuotationBean(int id, String author, String quotes) {
		super();
		this.author = author;
		this.quotes = quotes;
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public String getQuotes() {
		return quotes;
	}
	public int getId() {
		return id;
	}
	
}
