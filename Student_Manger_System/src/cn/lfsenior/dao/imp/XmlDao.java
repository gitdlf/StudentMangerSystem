package cn.lfsenior.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import cn.lfsenior.dao.IXmlDao;
import cn.lfsenior.entity.Student;
import cn.lfsenior.util.xml.XmlUtil;

public class XmlDao implements IXmlDao {

	@Override
	public void createDocument(String path, String fileName) {
		Document doc = DocumentHelper.createDocument();
		Element rootElem = doc.addElement("Work");
		XmlUtil.writerXml(path, fileName, doc);
	}

	@Override
	public int addElement(Student student, String path, String address,
			String workName) {
		try {
			Document doc = XmlUtil.readXml(path);
			// 先进行判断，如果address已经存在就不在添加
			Element judgeElem = (Element) doc
					.selectSingleNode("//student[@id='" + address + "']");
			if (judgeElem != null) {
				// 获得更标签
				Element rootElem = doc.getRootElement();
				Element studentElem = rootElem.addElement("student");
				studentElem.addAttribute("id", address);
				studentElem.addElement("userid").setText(
						String.valueOf(student.getlf_os_id()));
				studentElem.addElement("number").setText(
						student.getlf_os_number());
				studentElem.addElement("name").setText(student.getlf_os_name());
				studentElem.addElement("class").setText(
						student.getlf_os_class());
				studentElem.addElement("work").setText(workName);
				XmlUtil.writerXml(path, doc);
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	@Override
	public void delElement(Student student, String path) {
		Document doc = XmlUtil.readXml(path);
		// 获得要删除的标签对象
		Element delElem = (Element) doc.selectSingleNode("//number[text()='"
				+ student.getlf_os_number() + "']");
		delElem.detach();
		XmlUtil.writerXml(path, doc);
	}

	@Override
	public List<Student> findAll(String path) {
		// TODO Auto-generated method stub
		Document doc=XmlUtil.readXml(path);
		List<Element> list = (List<Element>)doc.selectNodes("//student");
		List<Student> students=new ArrayList<Student>();
		for(Element elem:list){
			Student stu=new Student();
			
		}
		return null;
	}

}
