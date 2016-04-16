package ph.coreproc.android.hacksyon.models;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

/**
 * Created by johneris on 4/16/16.
 */
public interface Candidate {

    int getId();

    @DrawableRes int getImage();

    @ColorRes int getColor();

    @ColorRes int getColorLight();

    String getName();

    String getDescription();

}
