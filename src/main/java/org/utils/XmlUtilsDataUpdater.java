package org.utils;

import org.entities.Department;
import org.entities.Employee;
import org.entities.Position;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XmlUtilsDataUpdater {
    public static void updateEmployees(List<Employee> employees, String filepath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElementNS(filepath, "employees");
            doc.appendChild(rootElement);
            for (Employee emp : employees) {
                rootElement.appendChild(getEmployee(doc, emp));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult file =
                    new StreamResult(new File(filepath));
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


    public static void updateDepartments(List<Department> departments, String filepath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElementNS(filepath, "departments");
            doc.appendChild(rootElement);
            for (Department department : departments) {
                rootElement.appendChild(getDepartment(doc, department));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult file =
                    new StreamResult(new File(filepath));
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

    public static void updatePositions(List<Position> positions, String filepath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElementNS(filepath,"positions");
            doc.appendChild(rootElement);
            for (Position position : positions) {
                rootElement.appendChild(getPosition(doc, position));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult file =
                    new StreamResult(new File(filepath));
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getPosition(Document doc, Position position) {
        Element element = doc.createElement("position");
        element.appendChild(getElements(doc, element, "id", String.valueOf(position.getId())));
        element.appendChild(getElements(doc, element, "name", position.getName()));
        element.appendChild(getElements(doc, element, "salary", String.valueOf(position.getSalary())));
        return element;
    }

    private static Node getElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild((doc.createTextNode(value)));
        return node;
    }
}
