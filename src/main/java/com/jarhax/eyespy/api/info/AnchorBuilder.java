package com.jarhax.eyespy.api.info;

import com.hypixel.hytale.server.core.ui.Anchor;
import com.hypixel.hytale.server.core.ui.Value;

public class AnchorBuilder {

    private Integer left = null;
    private Integer right = null;
    private Integer top = null;
    private Integer bottom = null;
    private Integer height = null;
    private Integer full = null;
    private Integer horizontal = null;
    private Integer vertical = null;
    private Integer width = null;
    private Integer minWidth = null;
    private Integer maxWidth = null;

    public AnchorBuilder() {
    }

    public void addHeight(int height) {
        this.height = this.height == null ? height : this.height + height;
    }

    public void ensureHeight(int height) {
        if (this.height == null || this.height < height) {
            this.height = height;
        }
    }

    public AnchorBuilder setLeft(Integer left) {
        this.left = left;
        return this;
    }

    public AnchorBuilder setRight(Integer right) {
        this.right = right;
        return this;
    }

    public AnchorBuilder setTop(Integer top) {
        this.top = top;
        return this;
    }

    public AnchorBuilder setBottom(Integer bottom) {
        this.bottom = bottom;
        return this;
    }

    public AnchorBuilder setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public AnchorBuilder setFull(Integer full) {
        this.full = full;
        return this;
    }

    public AnchorBuilder setHorizontal(Integer horizontal) {
        this.horizontal = horizontal;
        return this;
    }

    public AnchorBuilder setVertical(Integer vertical) {
        this.vertical = vertical;
        return this;
    }

    public AnchorBuilder setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public AnchorBuilder setMinWidth(Integer minWidth) {
        this.minWidth = minWidth;
        return this;
    }

    public AnchorBuilder setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    public Anchor build() {
        Anchor anchor = new Anchor();
        if (this.left != null) {
            anchor.setLeft(Value.of(this.left));
        }
        if (this.right != null) {
            anchor.setRight(Value.of(this.right));
        }
        if (this.top != null) {
            anchor.setTop(Value.of(this.top));
        }
        if (this.bottom != null) {
            anchor.setBottom(Value.of(this.bottom));
        }
        if (this.height != null) {
            anchor.setHeight(Value.of(this.height));
        }
        if (this.full != null) {
            anchor.setFull(Value.of(this.full));
        }
        if (this.horizontal != null) {
            anchor.setHorizontal(Value.of(this.horizontal));
        }
        if (this.vertical != null) {
            anchor.setVertical(Value.of(this.vertical));
        }
        if (this.width != null) {
            anchor.setWidth(Value.of(this.width));
        }
        if (this.minWidth != null) {
            anchor.setMinWidth(Value.of(this.minWidth));
        }
        if (this.maxWidth != null) {
            anchor.setMaxWidth(Value.of(this.maxWidth));
        }
        return anchor;
    }
}
