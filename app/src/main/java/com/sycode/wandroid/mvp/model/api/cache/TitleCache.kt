package com.sycode.wandroid.mvp.model.api.cache

import com.sycode.wandroid.mvp.model.entity.ApiResponse
import com.sycode.wandroid.mvp.model.entity.ClassifyResponse
import io.reactivex.Observable
import io.rx_cache2.DynamicKey
import io.rx_cache2.EvictProvider
import io.rx_cache2.LifeCache
import io.rx_cache2.Reply
import java.util.concurrent.TimeUnit

interface TitleCache {
    @LifeCache(duration = 7, timeUnit = TimeUnit.DAYS)
    fun getTitles(titles: Observable<ApiResponse<MutableList<ClassifyResponse>>>, cacheKey: DynamicKey, evictProvider: EvictProvider): Observable<Reply<ApiResponse<MutableList<ClassifyResponse>>>>
}