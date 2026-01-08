package com.jarhax.eyespy.api;

public interface InfoProvider<CTX extends Context, INFO> {

    void updateDescription(CTX context, INFO infoBuilder);
}