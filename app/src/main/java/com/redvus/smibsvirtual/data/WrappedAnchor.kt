package com.redvus.smibsvirtual.data

import com.google.ar.core.Anchor
import com.google.ar.core.Trackable

/**
 * Associates an Anchor with the trackable it was attached to. This is used to be able to check
 * whether or not an Anchor originally was attached to an {@link InstantPlacementPoint}.
 */
data class WrappedAnchor(
    val anchor: Anchor,
    val trackable: Trackable,
)