package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBo;
import com.nt.dao.IEmployeDao;
import com.nt.dto.EmployeeDto;
@Service("empService")
public class EmployeServiceMgmt implements IEmployeService {
	@Autowired
	private IEmployeDao dao;

	
	
	
	
	
	@Override
	public String fetchEmployeNameByNo(int empno) {
		return dao.getEmpNameByNo(empno);
	}//method
	
	@Override
	public List<EmployeeDto> fetchEmployeDataByDesg(String desg1, String desg2, String desg3) {
		List<EmployeeDto> listDto=new ArrayList();
		// invoke dao method
		List<EmployeeBo> listBo=dao.getEmpDetailsByDesg(desg1, desg2, desg3);
		listBo.forEach(bo->{
			EmployeeDto dto=new EmployeeDto();
			//copy property bo to dto
			BeanUtils.copyProperties(bo, dto);
			listDto.add(dto);
		});
		return listDto;
	}//method
	
	@Override
	public String InsertRecordIntoEmployee(EmployeeDto dto) {
		EmployeeBo bo=new EmployeeBo();
		BeanUtils.copyProperties(dto, bo);
		//invoke business Method
		int count=dao.insertEmpDetails(bo);
		return count==1?"Record Inserted":"Record NotInserted";
	}//method
	

}//class
