package com.zcl.alive.model.http;



import com.zcl.alive.model.bean.GankHttpResponse;
import com.zcl.alive.model.bean.GankItemBean;
import com.zcl.alive.model.bean.VideoRes;
import com.zcl.alive.model.http.response.VideoHttpResponse;

import java.util.List;

import io.reactivex.Observable;


/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface HttpHelper {

    Observable<VideoHttpResponse<VideoRes>> fetchHomePage();

    Observable<VideoHttpResponse<VideoRes>> fetchVideoInfo(String mediaId);

    Observable<VideoHttpResponse<VideoRes>> fetchVideoList(String catalogId, String pnum);

    Observable<VideoHttpResponse<VideoRes>> fetchVideoListByKeyWord(String keyword, String pnum);

    Observable<VideoHttpResponse<VideoRes>> fetchCommentList(String mediaId, String pnum);

    Observable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page);
}
