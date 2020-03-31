package org.utils;

import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlUtilsDataExtractor {
    public static List<Employee> extractEmployees() {
        String filepath = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\employees.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("employee");
            List<Employee> employees = new ArrayList<Employee>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                employees.add(getEmployeeXmlToObject(nodeList.item(i)));
            }
            return employees;
        } catch (Exception exc) {
            return null;
        }
    }

    private static Employee getEmployeeXmlToObject(Node node) {
        Employee employee = new Employee();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            employee.setId(Integer.parseInt(getTagValue("id", element)));
            employee.setFIO(getTagValue("fio", element));
            employee.setIdDepartment(Integer.parseInt(getTagValue("idDepartment", element)));
            employee.setPhoneNumber(getTagValue("phoneNumber", element));
            employee.setSeniority(Integer.parseInt(getTagValue("seniority", element)));
            employee.setIdPosition(Integer.parseInt(getTagValue("idPosition", element)));
        }
        return employee;
    }


    public static List<Department> extractDepartments() {
        String filepath = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\departments.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("department");
            List<Department> departments = new ArrayList<Department>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                departments.add(getDepartmentXmlToObject(nodeList.item(i)));
            }
            return departments;
        } catch (Exception exc) {
            return null;
        }
    }
    private static Department getDepartmentXmlToObject(Node node) {
        Department department = new Department();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            department.setId(Integer.parseInt(getTagValue("id", element)));
            department.setName(getTagValue("name", element));
            department.setChiefId(Integer.parseInt(getTagValue("chiefId", element)));
        }
        return department;
    }

    public static List<Position> extractPositions() {
        String filepath = "C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("position");
            List<Position> positions = new ArrayList<Position>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                positions.add(getPositionXmlToObject(nodeList.item(i)));
            }
            return positions;
        } catch (Exception exc) {
            return null;
        }
    }
    private static Position getPositionXmlToObject(Node node) {
        Position position = new Position();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            position.setId(Integer.parseInt(getTagValue("id", element)));
            position.setName(getTagValue("name", element));
            position.setSalary(Double.parseDouble(getTagValue("salary", element)));
        }
        return position;
    }

    public static void updateEmployees(List<Employee> employees) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElementNS("C:\\Users\\Darya\\Desktop\\Java\\HRApp\\employees.xml",
                            "employees");
            doc.appendChild(rootElement);
            for (Employee emp : employees) {
                rootElement.appendChild(getEmployee(doc, emp));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult file =
                    new StreamResult(new File("C:\\Users\\Darya\\Desktop\\Java\\HRApp\\employees.xml"));
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getEmployee(Document doc, Employee employee) {
        Element element = doc.createElement("employee");
        element.appendChild(getElements(doc, element, "id", String.valueOf(employee.getId())));
        element.appendChild(getElements(doc, element, "fio", employee.getFIO()));
        element.appendChild(getElements(doc, element, "idDepartment", String.valueOf(employee.getIdDepartment())));
        element.appendChild(getElements(doc, element, "phoneNumber", employee.getPhoneNumber()));
        element.appendChild(getElements(doc, element, "seniority", String.valueOf(employee.getSeniority())));
        element.appendChild(getElements(doc, element, "idPosition", String.valueOf(employee.getIdPosition())));
        return element;
    }


    public static void updateDepartments(List<Department> departments) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElementNS("C:\\Users\\Darya\\Desktop\\Java\\HRApp\\departments.xml",
                            "department");
            doc.appendChild(rootElement);
            for (Department department: departments) {
                rootElement.appendChild(getDepartment(doc,department));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult file =
                    new StreamResult(new File("C:\\Users\\Darya\\Desktop\\Java\\HRApp\\departments.xml"));
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Node getDepartment(Document doc, Department department) {
        Element element = doc.createElement("department");
        element.appendChild(getElements(doc, element, "id", String.valueOf(department.getId())));
        element.appendChild(getElements(doc, element, "name", department.getName()));
        element.appendChild(getElements(doc, element, "chiefId", String.valueOf(department.getChiefId())));
        return element;
    }
    public static void updatePositions(List<Position> positions) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElementNS("C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.xml",
                            "position");
            doc.appendChild(rootElement);
            for (Position position:positions) {
                rootElement.appendChild(getPosition(doc,position));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult file =
                    new StreamResult(new File("C:\\Users\\Darya\\Desktop\\Java\\HRApp\\positions.xml"));
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Node getPosition(Document doc,Position position) {
        Element element = doc.createElement("position");
        element.appendChild(getElements(doc, element, "id", String.valueOf(position.getId())));
        element.appendChild(getElements(doc, element, "name", position.getName()));
        element.appendChild(getElements(doc, element, "salary", String.valueOf(position.getSalary())));
        return element;
    }


    // получаем значение элемента по указанному тегу
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    private static Node getElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild((doc.createTextNode(value)));
        return node;
    }
}
