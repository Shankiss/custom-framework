package ${basePackage}.controller;

import ${basePackage}.annotation.MyLog;
import ${basePackage}.common.ResponseMsg;
import ${basePackage}.utils.ResponseUtil;
import ${basePackage}.common.ServiceException;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import ${basePackage}.dto.base.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @Description TODO
* @Date ${date}
* @Created by ${author}
* @Copyright Copyright (c) zyuc
*/
@RestController
@RequestMapping("/api${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

    @Autowired
    private I${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping
    @MyLog(description = "新增${comment}")
    public ResponseMsg insert(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        try {
            return ResponseUtil.success(${modelNameLowerCamel}Service.insert(${modelNameLowerCamel}));
        } catch (ServiceException e) {
            return ResponseUtil.error(e);
        }
    }

    @DeleteMapping("/{id}")
    @MyLog(description = "删除${comment}")
    public ResponseMsg delete(@PathVariable Integer id) {
        try {
            ${modelNameLowerCamel}Service.delete(id);
            return ResponseUtil.success();
        } catch (ServiceException e) {
            return ResponseUtil.error(e);
        }
    }

    @PutMapping
    @MyLog(description = "修改${comment}")
    public ResponseMsg update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        try {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
            return ResponseUtil.success();
        } catch (ServiceException e) {
            return ResponseUtil.error(e);
        }
    }

    @GetMapping("/{id}")
    @MyLog(description = "检索${comment}详情")
    public ResponseMsg get(@PathVariable Integer id) {
        try {
            return ResponseUtil.success(${modelNameLowerCamel}Service.get(id));
        } catch (ServiceException e) {
            return ResponseUtil.error(e);
        }
    }

    @GetMapping
    @MyLog(description = "检索${comment}列表")
    public ResponseMsg page(${modelNameUpperCamel} ${modelNameLowerCamel}, PageBean pageBean) {
        try {
            PageHelper.startPage(pageBean.getPageNum(), pageBean.getPageSize());
            List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.page(${modelNameLowerCamel});
            return ResponseUtil.success(new PageInfo(list));
        } catch (ServiceException e) {
            return ResponseUtil.error(e);
        }
    }

}
