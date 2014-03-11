package com.zb.demo.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zb.demo.entity.Userinfos;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userinfos entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zb.demo.entity.Userinfos
 * @author MyEclipse Persistence Tools
 */

public class UserinfosDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(UserinfosDAO.class);
	// property constants
	public static final String USERNAME = "username";

	protected void initDao() {
		// do nothing
	}

	public void save(Userinfos transientInstance) {
		log.debug("saving Userinfos instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userinfos persistentInstance) {
		log.debug("deleting Userinfos instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userinfos findById(java.lang.Long id) {
		log.debug("getting Userinfos instance with id: " + id);
		try {
			Userinfos instance = (Userinfos) getHibernateTemplate().get(
					"com.zb.demo.entity.Userinfos", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Userinfos instance) {
		log.debug("finding Userinfos instance by example");
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
		log.debug("finding Userinfos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userinfos as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findAll() {
		log.debug("finding all Userinfos instances");
		try {
			String queryString = "from Userinfos";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userinfos merge(Userinfos detachedInstance) {
		log.debug("merging Userinfos instance");
		try {
			Userinfos result = (Userinfos) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userinfos instance) {
		log.debug("attaching dirty Userinfos instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userinfos instance) {
		log.debug("attaching clean Userinfos instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserinfosDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserinfosDAO) ctx.getBean("UserinfosDAO");
	}
	//按名字列模糊查询
	public List<Userinfos> findUserByName(String name){
		Session session = getSession();
		Query query = session.createQuery("from Userinfos us where username like :name");
		query.setString("name", "%"+name+"%");
		List<Userinfos> list = query.list();
		session.close();
		return list;
	}
}


