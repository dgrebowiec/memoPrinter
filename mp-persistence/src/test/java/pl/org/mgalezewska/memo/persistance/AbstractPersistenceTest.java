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
package pl.org.mgalezewska.memo.persistance;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.beans.Introspector;
import java.util.Map;

/**
 * @author Ma�gorzata Ga��ewska <mgalezewska@opi.org.pl>
 */
@Transactional
@ContextConfiguration({"classpath:META-INF/persistence-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractPersistenceTest {

    @Inject
    protected ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }
}
