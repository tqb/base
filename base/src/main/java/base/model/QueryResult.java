package base.model;

import java.io.Serializable;
import java.util.List;

public class QueryResult<E> implements Serializable {
	private static final long serialVersionUID = 1L;

	private long total;
	private List<E> result;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<E> getResult() {
		return result;
	}

	public void setResult(List<E> result) {
		this.result = result;
	}

}
