<?php

class ProductAddDefaultModuleFrontController extends ModuleFrontController {

    public function initContent() {

        parent :: initContent();
        $this->setTemplate('form.tpl');
        if ($_SERVER['REQUEST_METHOD'] == 'POST') {
            $active = false;
            $title = Tools :: getValue('title', false);
            $descriptionmodel = Tools :: getValue('despcriptionmodel', false);
            Db :: getInstance()->insert('productmodel', array(
                'title'=>$title,
                'descriptionmodel'=>$descriptionmodel,
                'active'=>$active
            ));
            $link = new Link();
            Tools :: redirect($link->getModuleLink('productadd', 'default')); 
            }
           
        }
    
}