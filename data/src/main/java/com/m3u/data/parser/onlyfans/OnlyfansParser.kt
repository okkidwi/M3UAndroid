package com.m3u.data.parser.onlyfans

import com.m3u.data.parser.onlyfans.dto.OnlyfansPost

internal interface OnlyfansParser {
    suspend fun parse(input: OnlyfansInput): List<OnlyfansPost>
}