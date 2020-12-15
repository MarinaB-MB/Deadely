package com.deadely.piegallery.ui.authorpage

import com.deadely.piegallery.base.BaseView
import com.deadely.piegallery.dataclasses.UserProfile
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SkipStrategy::class)
interface AuthorPageView : BaseView {
    fun setPhoto(user: UserProfile)
}
