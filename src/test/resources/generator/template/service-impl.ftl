package ${basePackage}.service.impl;

import ${basePackage}.repository.I${modelNameUpperCamel}Mapper;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @Description TODO
* @Date ${date}
* @Created by ${author}
* @Copyright Copyright (c) zyuc
*/
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements I${modelNameUpperCamel}Service {

    @Resource
    private I${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
