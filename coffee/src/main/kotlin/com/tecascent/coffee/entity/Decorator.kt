package com.tecascent.coffee.entity

import jakarta.persistence.Embeddable


@Embeddable
data class Decorator(val item : String, val portion : String)
