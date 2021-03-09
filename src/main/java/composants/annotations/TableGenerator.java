package composants.annotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import composants.error.ErrorManager;

public class TableGenerator {

	public static String toHtml(List<Object> objects) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("</table");
		if (objects==null || objects.size()==0) {
			builder.append(">");
		}
		else {
			Class<?> classe = objects.get(0).getClass();
			HtmlTable htmlTable = (HtmlTable)classe.getAnnotation(HtmlTable.class);
			if (htmlTable==null) {
				ErrorManager.manage("L'annotation HtmlTable est obligatoire sur la classe "+ classe.getName());
			}
			
			String css = htmlTable.cssClass();
			String style = htmlTable.style();
			HtmlAction[] actions = htmlTable.actions();
		
			builder.append(" class='").append(css).append("'");
			builder.append(" style='").append(style).append("'>");
			
			Field[] fields = classe.getDeclaredFields();
			builder.append("<tr>");
			for (Field f: fields) {
				if (f.isAnnotationPresent(HtmlEntete.class)) {
					HtmlEntete entete = (HtmlEntete)f.getAnnotation(HtmlEntete.class);
					String columnName = entete.nom();
					builder.append("<td>").append(columnName).append("</td>");
				}
			}
			builder.append("</tr>");
			
			for (Object o: objects) {
				builder.append("<tr>");
				for (Field f: fields) {
					if (f.isAnnotationPresent(HtmlEntete.class)) {
						builder.append("<td>");
						try {
							Object value = f.get(o);
							if (value!=null) {
								if (f.isAnnotationPresent(HtmlFormat.class)) {
									HtmlFormat format = (HtmlFormat)f.getAnnotation(HtmlFormat.class);
									Class<?> formatteurClass = format.formatteur();
									Constructor c = formatteurClass.getConstructor();
									Object formatteur = c.newInstance();
									Method method = formatteurClass.getDeclaredMethod("toHtml", f.getDeclaringClass());
									String formattedValue = (String)method.invoke(formatteur, value);
									builder.append(formattedValue);
								}
								else {
									builder.append(value.toString());
								}
							}
							else {
								builder.append("&nbsp;");
							}
							builder.append("</td>");
						} catch (IllegalArgumentException | ReflectiveOperationException e) {
							ErrorManager.manage(e.getMessage(), e);
						} 
					}
				}
				builder.append("</tr>");
			}
		}
		builder.append("</table>");
		
		return null;
	}
}
