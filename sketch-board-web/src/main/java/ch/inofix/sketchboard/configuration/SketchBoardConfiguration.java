package ch.inofix.sketchboard.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author      Michael Lustenberger
 * @created     2018-06-23
 * @modified    2018-06-23
 * @version     1.0.0
 */
@Meta.OCD(
    id = "ch.inofix.sketchboard.configuration.SketchBoardConfiguration",
    localization = "content/Language", name = "sketchboard.configuration.name"
)
public interface SketchBoardConfiguration {

    @Meta.AD(deflt = "show-list", required = false)
    public String startup();
}
