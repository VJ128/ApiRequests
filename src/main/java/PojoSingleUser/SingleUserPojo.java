package PojoSingleUser;

public class SingleUserPojo {
private DataPojo data;
private SupportPojo support;
SingleUserPojo(){}
public SingleUserPojo(DataPojo data, SupportPojo support) {
	this.data = data;
	this.support = support;
}
public DataPojo getData() {
	return data;
}
public void setData(DataPojo data) {
	this.data = data;
}
public SupportPojo getSupport() {
	return support;
}
public void setSupport(SupportPojo support) {
	this.support = support;
}
@Override
public String toString() {
	return "SingleUserPojo {data=" + data + ", support=" + support + "}";
}


}
