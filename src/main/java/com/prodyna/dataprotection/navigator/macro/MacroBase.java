package com.prodyna.dataprotection.navigator.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.Map;

/**
 * The base for all defined Macros.
 */
abstract class MacroBase implements Macro {

    private static final String TEMPLATE_ROOT_PATH = "templates/macro/";

    private final Map<String, Object> context = MacroUtils.defaultVelocityContext();

    /**
     * Get the name of the view template.
     *
     * @return the name of the template inside the TEMPLATE_ROOT_PATH
     */
    protected abstract String getVelocityTemplate();

    @Override
    public BodyType getBodyType() {
        return BodyType.RICH_TEXT;
    }

    @Override
    public OutputType getOutputType() {
        return OutputType.BLOCK;
    }

    /**
     * Execute the macro rendering.
     *
     * @param map               the context map for the view
     * @param s                 The content of the macro.
     * @param conversionContext is not used here.
     * @return The parsed velocity template as an String.
     */
    @Override
    public String execute(Map<String, String> map, String s, ConversionContext conversionContext) {
        this.context.put("Content", s);
        fillContext(map);
        String content = VelocityUtils.getRenderedTemplate(getTemplatePath(), context);
        return StringEscapeUtils.unescapeHtml(content);
    }

    /**
     * Get the path to the template for the rendering.
     *
     * @return the template path.
     */
    private String getTemplatePath() {
        return String.format("%s%s", TEMPLATE_ROOT_PATH, getVelocityTemplate());
    }

    /**
     * Fill the context for velocity with the parameters from the macro.
     *
     * @param macroMap the parameters from the macro.
     */
    private void fillContext(Map<String, String> macroMap) {
        for (String macroKey : macroMap.keySet()) {
            this.context.put(macroKey, macroMap.get(macroKey));
        }
    }
}
