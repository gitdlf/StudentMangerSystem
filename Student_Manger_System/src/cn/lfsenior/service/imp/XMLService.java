package cn.lfsenior.service.imp;

import cn.lfsenior.dao.IXmlDao;
import cn.lfsenior.dao.imp.XmlDao;
import cn.lfsenior.entity.Student;
import cn.lfsenior.service.IXmlService;

public class XMLService implements IXmlService {
	
	private IXmlDao xmlDao=new XmlDao();

	@Override
	public void createDocument(String path, String fileName) {
		try {
			xmlDao.createDocument(path, fileName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addElement(Student student, String path, String address,
			String workName) {
		try {
			return xmlDao.addElement(student, path, address, workName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}

	@Override
	public void delElement(Student student, String path) {
		try {
			xmlDao.delElement(student, path);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
