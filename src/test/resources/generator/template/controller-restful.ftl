package ${basePackage}.web;

import ${basePackage}.annotation.MyLog;
import ${basePackage}.common.ResponseMsg;
import ${basePackage}.utils.ResponseUtil;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static ${basePackage}.constant.DigitalConstant.*;

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
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResponseUtil.success();
    }

    @DeleteMapping("/{id}")
    @MyLog(description = "删除${comment}")
    public ResponseMsg delete(@PathVariable Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
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
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResponseUtil.success(${modelNameLowerCamel});
    }

    @GetMapping
    @MyLog(description = "检索${comment}列表")
    public ResponseMsg list(@RequestParam(defaultValue = DEFAULT_PAGE_NUM) Integer page,
                            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResponseUtil.success(pageInfo);
    }
}
