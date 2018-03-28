package com.scfl.dispatching.center.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.scfl.base.controller.BaseController;
import com.scfl.base.utils.Result;
import com.scfl.dispatching.center.entity.OuterInvokingClass;
import com.scfl.dispatching.center.entity.OuterInvokingJar;
import com.scfl.dispatching.center.entity.OuterInvokingMethod;
import com.scfl.dispatching.center.service.OuterInvokingClassService;
import com.scfl.dispatching.center.service.OuterInvokingJarService;
import com.scfl.dispatching.center.service.OuterInvokingMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 外部类配置
 * @author ylw
 * @date 18-3-26 下午3:18
 * @param
 * @return
 */
@RestController
@RequestMapping("/outer/config")
public class OuterInvokingConfigController extends BaseController{
    private static final long serialVersionUID = 8877970937683458594L;

    @Autowired
    private OuterInvokingJarService outerInvokingJarService;
    @Autowired
    private OuterInvokingClassService outerInvokingClassService;
    @Autowired
    private OuterInvokingMethodService outerInvokingMethodService;

    /**
     * jar配置列表
     * @return
     */
    @GetMapping("/jar")
    public Result jarList(){
        return Result.OK(outerInvokingJarService.selectList(null));
    }

    /**
     * 新增jar配置
     * @param outerInvokingJar
     * @return
     */
    @PostMapping("/jar/add")
    public Result addJar(OuterInvokingJar outerInvokingJar){
        return Result.OK(outerInvokingJarService.insert(outerInvokingJar));
    }

    /**
     * 更新jar配置
     * @param outerInvokingJar
     * @return
     */
    @PostMapping("/jar/update")
    public Result updateJar(OuterInvokingJar outerInvokingJar){
        return Result.OK(outerInvokingJarService.updateById(outerInvokingJar));
    }

    /**
     * 删除jar配置
     * @param id
     * @return
     */
    @GetMapping("/jar/delete/{id}")
    public Result deleteJar(@PathVariable String id){
        return Result.OK(outerInvokingJarService.deleteById(id));
    }


    /**
     * 类配置列表
     * @return
     */
    @GetMapping("/jar/class/")
    public Result classList(){
        return Result.OK(outerInvokingClassService.selectList(null));
    }

    /**
     * jar主键查询对应类列表
     * @author ylw
     * @date 18-3-26 下午3:48
     * @return com.scfl.base.utils.Result
     */
    @GetMapping("/jar/class/{jarId}")
    public Result classListByJarId(@PathVariable String jarId){
        return Result.OK(outerInvokingClassService.selectList(new EntityWrapper<OuterInvokingClass>()
                .where("pid={0}",jarId)));
    }

    /**
     * 新增类
     * @param outerInvokingClass
     * @return
     */
    @PostMapping("/jar/class/add")
    public Result addClass(OuterInvokingClass outerInvokingClass){
        return Result.OK(outerInvokingClassService.insert(outerInvokingClass));
    }

    /**
     * 更新类
     * @param outerInvokingClass
     * @return
     */
    @PostMapping("/jar/class/update")
    public Result updateClass(OuterInvokingClass outerInvokingClass){
        return Result.OK(outerInvokingClassService.updateById(outerInvokingClass));
    }

    /**
     * 删除类
     * @param id
     * @return
     */
    @GetMapping("/jar/class/delete/{id}")
    public Result deleteClass(@PathVariable String id){
        return Result.OK(outerInvokingClassService.deleteById(id));
    }

    /**
     * 删除与jar关联类信息
     * @param jarId
     * @return
     */
    @GetMapping("/jar/class/delete/relation/{jarId}")
    public Result deleteClassByJarId(@PathVariable String jarId){
        return Result.OK(outerInvokingClassService.delete(new EntityWrapper<OuterInvokingClass>()
                .where("pid={0}",jarId)));
    }

    /**
     * 查询所有方法列表
     * @return
     */
    @GetMapping("/jar/class/method")
    public Result methodList(){
        return Result.OK(outerInvokingMethodService.selectList(null));
    }

    /**
     * 类关联方法列表
     * @param classId
     * @return
     */
    @GetMapping("/jar/class/method/{classId}")
    public Result methodListByClassId(@PathVariable String classId){
        return Result.OK(outerInvokingMethodService.selectList(new EntityWrapper<OuterInvokingMethod>()
                .where("pid={0}",classId)));
    }

    /**
     * 新增方法
     * @param outerInvokingMethod
     * @return
     */
    @PostMapping("/jar/class/method/add")
    public Result addMethod(OuterInvokingMethod outerInvokingMethod){
        return Result.OK(outerInvokingMethodService.insert(outerInvokingMethod));
    }

    /**
     * 新增方法
     * @param outerInvokingMethod
     * @return
     */
    @PostMapping("/jar/class/method/update")
    public Result updateMethod(OuterInvokingMethod outerInvokingMethod){
        return Result.OK(outerInvokingMethodService.updateById(outerInvokingMethod));
    }

    /**
     * 删除方法
     * @param id
     * @return
     */
    @PostMapping("/jar/class/method/delete/{id}")
    public Result deleteMethod(@PathVariable String id){
        return Result.OK(outerInvokingMethodService.deleteById(id));
    }

    /**
     * 删除类关联的方法
     * @param classId
     * @return
     */
    @GetMapping("/jar/class/method/delete/relation/{classId}")
    public Result deleteMethodByClassId(@PathVariable String classId){
        return Result.OK(outerInvokingMethodService.delete(new EntityWrapper<OuterInvokingMethod>()
                .where("classId={0}",classId)));
    }
}
