/*
 * To oprogramowanie jest w�asno�ci�
 *
 * OPI - O�rodek Przetwarzania Informacji,
 * Al. Niepodleg�o�ci 188B, 00-608 Warszawa
 * Numer KRS: 0000127372
 * S�d Rejonowy dla m. st. Warszawy w Warszawie XII Wydzia�
 * Gospodarczy KRS
 * REGON: 006746090
 * NIP: 525-000-91-40
 * Wszystkie prawa zastrze�one. To oprogramowanie mo�e by� u�ywane tylko
 * zgodnie z przeznaczeniem. OPI nie odpowiada za ewentualne wadliwe
 * dzia�anie kodu.
 */
package pl.org.mgalezewska.memo.persistence.dao.common;

import com.mysema.query.types.EntityPath;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Ma�gorzata Ga��ewska <mgalezewska@opi.org.pl>
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
