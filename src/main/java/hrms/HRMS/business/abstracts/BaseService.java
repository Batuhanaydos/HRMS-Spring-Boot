package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.DataResult;

import hrms.HRMS.core.utilities.results.Result;
public interface BaseService<T> {
	public DataResult<List<T>> getAll();
	public Result add(T entity);
}