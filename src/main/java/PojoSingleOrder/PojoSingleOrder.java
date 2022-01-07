package PojoSingleOrder;

public class PojoSingleOrder {
	 private String  id;
	   private String  bookId;
	   private String  customerName;
	   private String  createdBy;
	   private String  quantity;
	   private String  timestamp;
	   PojoSingleOrder (){}
	public PojoSingleOrder(String id, String bookId, String customerName, String createdBy, String quantity,
			String timestamp) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.customerName = customerName;
		this.createdBy = createdBy;
		this.quantity = quantity;
		this.timestamp = timestamp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "PojoOrders [id=" + id + ", bookId=" + bookId + ", customerName=" + customerName + ", createdBy="
				+ createdBy + ", quantity=" + quantity + ", timestamp=" + timestamp + "]";
	}
	   
	   
}
