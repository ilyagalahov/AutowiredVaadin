package ru.ecmsolutions.views;

import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.ecmsolutions.beans.ApplicationCounter;
import ru.ecmsolutions.beans.CustomCounter;
import ru.ecmsolutions.beans.SessionCounter;
import ru.ecmsolutions.components.ChooseLanguage;
import ru.ecmsolutions.components.SimpleForm;
import ru.xpoft.vaadin.VaadinView;
import ru.ecmsolutions.beans.ApplicationCounter;
import ru.ecmsolutions.beans.CustomCounter;
import ru.ecmsolutions.beans.SessionCounter;
import ru.ecmsolutions.components.ChooseLanguage;
import ru.ecmsolutions.components.SimpleForm;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * @author xpoft
 */
@Component
@Scope("prototype")
@VaadinView(MainView.NAME)
public class MainView extends Panel implements View
{
    public static final String NAME = "";

    @Autowired
    private SimpleForm form;

    //@Autowired
    //private SessionCounter sessionCounter;

  //  @Autowired
    //private ChooseLanguage chooseLanguage;

    @Autowired
    private ApplicationCounter applicationCounter;

    @Autowired
    private CustomCounter customCounter;

    @PostConstruct
    public void PostConstruct()
    {
        setSizeFull();

        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);

        layout.addComponent(form);

        layout.addComponent(new Button("Show counts", new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                Notification.show(String.format("%d", customCounter.getCount(), applicationCounter.getCount()));
            }
        }));

        layout.addComponent(new Link("Go to the Label View", new ExternalResource("#!" + LabelView.NAME)));
        layout.addComponent(new Link("Go to the Error View. I18n error messages", new ExternalResource("#!" + ErrorView.NAME)));
        layout.addComponent(new Link("Go to the I18N View", new ExternalResource("#!" + I18N.NAME)));
        layout.addComponent(new Link("Go to the UI scoped View", new ExternalResource("#!" + UIScopedView.NAME)));

        // Have a component that implements Viewer interface
        final TextField tf = new TextField ("Name");
// Have a data model with some data

// Wrap it in an ObjectProperty

        Button russian = new Button("CHANGE IT", new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent event)
            {
                customCounter.count = 8;
            }
        });


                ObjectProperty property =
                new ObjectProperty(customCounter.count.toString(), CustomCounter.class);
//Bind the property to the component
        tf.setPropertyDataSource(property);


        tf.addValueChangeListener(
                new Property.ValueChangeListener() {
                    public void valueChange(Property.ValueChangeEvent event) {
// Do something with the new value

                        customCounter.count = Integer.valueOf(tf.getValue());
                        //layout.addComponent(new Label(tf.getValue()));
                    }
                });
        layout.addComponent(tf);
        layout.addComponent(russian);

      // layout.addComponent(chooseLanguage);


//        ObjectProperty property =
//                new ObjectProperty("Hello", String.class);
//// Have a component that implements Viewer
//        Label viewer = new Label();
//// Bind it to the data
//        viewer.setPropertyDataSource(property);

        setContent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event)
    {
    }
}
