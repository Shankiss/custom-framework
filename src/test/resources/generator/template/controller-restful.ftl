package ${basePackage}.controller;

import ${basePackage}.annotation.MyLog;
import ${basePackage}.common.ResponseMsg;
import ${basePackage}.utils.ResponseUtil;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping
    @MyLog(description = "新增${comment}")
    public ResponseMsg add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.insert(${modelNameLowerCamel});
        return ResponseUtil.success();
    }

    @DeleteMapping("/{id}")
    @MyLog(description = "删除${comment}")
    public ResponseMsg delete(@PathVariable Integer id) {
        ${modelNameLowerCamel}Service.delete(id);
        return ResponseUtil.success();
    }

    @PutMapping
    @MyLog(description = "修改${comment}")
    public ResponseMsg update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResponseUtil.success();
    }

    @GetMapping("/{id}")
    @MyLog(description = "检索${comment}详情")
    public ResponseMsg detail(@PathVariable Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.get(id);
        return ResponseUtil.success(${modelNameLowerCamel});
    }

    @GetMapping
    @MyLog(description = "检索${comment}列表")
    public ResponseMsg list(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        PageHelper.startPage(${modelNameLowerCamel}.getPageNo(), ${modelNameLowerCamel}.getPageSize());
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.page(${modelNameLowerCamel});
        PageInfo pageInfo = new PageInfo(list);
        return ResponseUtil.success(pageInfo);
    }
}
