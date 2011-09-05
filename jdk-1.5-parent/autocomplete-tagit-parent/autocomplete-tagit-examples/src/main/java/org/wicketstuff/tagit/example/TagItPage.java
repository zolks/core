package org.wicketstuff.tagit.example;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.tagit.TagItTextField;

/**
 * 
 */
public class TagItPage extends WebPage
{

	private static final long serialVersionUID = 1L;

	public TagItPage(final PageParameters parameters)
	{
		super(parameters);

		Form<Void> form = new Form<Void>("form") {

            @Override
            protected void onSubmit() {
                super.onSubmit();
                
                System.err.println("tagit: " + get("tagit").getDefaultModelObjectAsString());
            }
		    
		};
		add(form);
		
		form.add(new TagItTextField<String>("tagit", Model.of("a1, a4")) {

            @Override
            protected Iterable<String> getChoices(String input) {
                
                System.err.println("> " + input.toString());
                
                return Arrays.asList("a1", "a2", "a3", "a4");
            }

        });

	}
}