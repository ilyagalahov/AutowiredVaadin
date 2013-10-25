package ru.ecmsolutions;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.xpoft.vaadin.DiscoveryNavigator;


/**
 * @author xpoft
 */
@Component
@Scope("prototype")
public class MyUI extends UI
{
    @Autowired
    private transient ApplicationContext applicationContext;
    @Override
    protected void init(final VaadinRequest request)
    {
        setSizeFull();

        DiscoveryNavigator navigator = new DiscoveryNavigator(this, this);

    }
}
