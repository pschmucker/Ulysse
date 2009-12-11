package org.qualipso.factory.eventqueue.entity;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Rule class represents a tuple of regular expression (subject, object,
 * target). Rules can be registered on event queues for filtering events.
 * 
 * The registering of rules on a single queue is additive, which means that if
 * two complementary rules was registered on the same queue, all events will be
 * pushed in this queue. For example : <br/>
 * <ul>
 * <li>eventQueueService.register("^[a-m].*$", ".*", ".*", "queuePath")</li>
 * <li>eventQueueService.register("^[n-z].*$", ".*", ".*", "queuePath")</li>
 * </ul>
 * Here we registered two rules. The first matches all subjects who begin with a
 * letter between a and m. The second matches all subjects who begin with a
 * letter between n and z. Both rules are complementary, so the union will be
 * made for filtering events. The queue will accept all the events who have a
 * subject beginning with a letter between a and z.
 * 
 * @author Nicolas HENRY
 * @author Marlène HANTZ
 * @author Philippe SCHMUCKER
 */
@Entity
@XmlType(name = "Rule", namespace = "http://org.qualipso.factory.ws/entity", propOrder = { "id", "subjectre", "objectre", "targetre", "queuePath" })
public class Rule implements Serializable {

    private static final long serialVersionUID = -3537424425785767451L;
    private static Log logger = LogFactory.getLog(Rule.class);

    /**
     * ID for the rule
     */
    @Id
    private String id;

    /**
     * Returns the ID for this rule
     * 
     * @return the ID for this rule
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID for this rule
     * 
     * @param id
     *            the ID for this rule
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Regular expression used to match the subject of events
     */
    private String subjectre;

    /**
     * Regular expression used to match the object of events
     */
    private String objectre;

    /**
     * Regular expression used to match the target of events
     */
    private String targetre;

    /**
     * Path of the queue on which this rule is registered
     */
    private String queuePath;

    /**
     * Returns the regular expression used to match the subject of events
     * 
     * @return the regular expression for the subject of events
     */
    public String getSubjectre() {
        return subjectre;
    }

    /**
     * Sets the regular expression used to match the subject of events
     * 
     * @param subjectre
     *            the regular expression for the subject of events
     */
    public void setSubjectre(String subjectre) {
        this.subjectre = subjectre;
    }

    /**
     * Returns the regular expression used to match the object of events
     * 
     * @return the regular expression for the object of events
     */
    public String getObjectre() {
        return objectre;
    }

    /**
     * Sets the regular expression used to match the object of events
     * 
     * @param objectre
     *            the regular expression for the object of events
     */
    public void setObjectre(String objectre) {
        this.objectre = objectre;
    }

    /**
     * Returns the regular expression used to match the target of events
     * 
     * @return the regular expression for the target of events
     */
    public String getTargetre() {
        return targetre;
    }

    /**
     * Sets the regular expression used to match the target of events
     * 
     * @param targetre
     *            the regular expression for the target of events
     */
    public void setTargetre(String targetre) {
        this.targetre = targetre;
    }

    /**
     * Returns the path of the queue on which this rule is registered
     * 
     * @return the path of the queue
     */
    public String getQueuePath() {
        return queuePath;
    }

    /**
     * Sets the path of the queue on which this rule is registered
     * 
     * @param queuePath
     *            the path of the queue
     */
    public void setQueuePath(String queuePath) {
        this.queuePath = queuePath;
    }

    /**
     * Tests if subject matches the subject regular expression of this rule
     * 
     * @param subject
     *            subject to match
     * @return true if the subject matches the subject regular expression
     */
    public boolean matchBySubjectRE(String subject) {
        logger.info("matchBySubjectRE(...) called");
        Pattern p = Pattern.compile(subjectre);
        Matcher m = p.matcher(subject);
        return m.matches();
    }

    /**
     * Tests if object matches the object regular expression of this rule
     * 
     * @param object
     *            object to match
     * @return true if the object matches the object regular expression
     */
    public boolean matchByObjectRE(String object) {
        logger.info("matchByObjectRE(...) called");
        Pattern p = Pattern.compile(objectre);
        Matcher m = p.matcher(object);
        return m.matches();
    }

    /**
     * Tests if target matches the target regular expression of this rule
     * 
     * @param target
     *            target to match
     * @return true if the target matches the target regular expression
     */
    public boolean matchByTargetRE(String target) {
        logger.info("matchByTargetRE(...) called");
        Pattern p = Pattern.compile(targetre);
        Matcher m = p.matcher(target);
        return m.matches();
    }

    /**
     * Tests if the event in parameter matches this rule
     * 
     * @param e
     *            the event to match
     * @return true if the event matches this rule
     */
    public boolean match(Event e) {
        logger.info("match(...) called");

        boolean b1 = matchBySubjectRE(e.getThrowedBy());
        logger.debug("subject " + subjectre + " " + e.getThrowedBy());

        boolean b2 = matchByObjectRE(e.getEventType());
        logger.debug("objectre " + objectre + " " + e.getEventType());

        boolean b3 = matchByTargetRE(e.getFromResource());
        logger.debug("targetre " + targetre + " " + e.getFromResource());

        logger.debug("m1 " + b1 + " m2 " + b2 + " m3 " + b3);
        return b1 && b2 && b3;
    }

    @Override
    public String toString() {
        return "Rule :\nsubjectre = \"" + subjectre + "\"\nobjectre = \"" + objectre + "\"\ntargetre = \"" + targetre + "\"\nqueuePath = \"" + queuePath + "\"";
    }

    /**
     * Tests if queue of this rule matches the queue regular expression
     * 
     * @param queuere
     *            queue regular expression to test
     * @return true if the queue matches the queue regular expression
     */
    public boolean matchByQueue(String queuere) {
        logger.info("matchByQueue(...) called");
        Pattern p = Pattern.compile(queuere);
        Matcher m = p.matcher(queuePath);
        return m.matches();
    }

}
