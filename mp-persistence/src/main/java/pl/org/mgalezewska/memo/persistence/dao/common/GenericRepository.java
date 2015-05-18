package pl.org.mgalezewska.memo.persistence.dao.common;

import com.mysema.query.types.EntityPath;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Malgorzata Galezewska <mgalezewska@opi.org.pl>
 */
public abstract class GenericRepository<T, ID extends Serializable> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    @PostConstruct
    @SuppressWarnings("unchecked")
    private void initGenericTypes() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] generics = type.getActualTypeArguments();
        this.type = (Class<T>) generics[0];
    }

    public abstract EntityPath<T> model();

    public T findById(ID id) {
        return em.find(type, id);
    }
}
