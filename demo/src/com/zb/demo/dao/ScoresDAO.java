package com.zb.demo.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zb.demo.entity.Scores;

/**
 * A data access object (DAO) providing persistence and search support for
 * Scores entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zb.demo.entity.Scores
 * @author MyEclipse Persistence Tools
 */

public class ScoresDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ScoresDAO.class);
	// property constants
	public static final String SCORE = "score";

	protected void initDao() {
		// do nothing
	}

	public void save(Scores transientInstance) {
		log.debug("saving Scores instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Scores persistentInstance) {
		log.debug("deleting Scores instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Scores findById(java.lang.Long id) {
		log.debug("getting Scores instance with id: " + id);
		try {
			Scores instance = (Scores) getHibernateTemplate().get(
					"com.zb.demo.entity.Scores", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Scores instance) {
		log.debug("finding Scores instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Scores instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Scores as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findAll() {
		log.debug("finding all Scores instances");
		try {
			String queryString = "from Scores";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Scores merge(Scores detachedInstance) {
		log.debug("merging Scores instance");
		try {
			Scores result = (Scores) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Scores instance) {
		log.debug("attaching dirty Scores instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Scores instance) {
		log.debug("attaching clean Scores instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ScoresDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ScoresDAO) ctx.getBean("ScoresDAO");
	}
}