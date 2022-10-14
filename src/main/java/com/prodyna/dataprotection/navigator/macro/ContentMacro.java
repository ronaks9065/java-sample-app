package com.prodyna.dataprotection.navigator.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.Map;

/**
 * The macro for defining the "datenschutz-navigator-contents"
 */
public class ContentMacro implements Macro {

    @Override
    public String execute(Map<String, String> map, String s, ConversionContext conversionContext) {
        Map<String, Object> context = MacroUtils.defaultVelocityContext();
        context.put("Content", s);
        // TODO: try this: context.putAll(map);
        this.fillContext(context, map);
        String content = VelocityUtils.getRenderedTemplate("templates/macro/ContentMacro.vm", context);
        return StringEscapeUtils.unescapeHtml(content);
    }

    @Override
    public BodyType getBodyType() {
        return BodyType.RICH_TEXT;
    }

    @Override
    public OutputType getOutputType() {
        return OutputType.BLOCK;
    }

    private void fillContext(Map<String, Object> velocityContext, Map<String, String> macroMap) {
        for (String macroKey : macroMap.keySet()) {
            velocityContext.put(macroKey, macroMap.get(macroKey));
        }
    }
}
