<?php
class AdminProductAddValidController extends ModuleAdminController {

    public function __construct(){
        $this->module = 'productadd';
        $this->bootstrap = true;
        $this->display = 'view';
        parent::__construct();
        $this->context = Context::getContext();
    }
    public function init(){
        parent::init();
    }
    public function initContent(){
        parent::initContent();
        $sql = 'select id_productmodel, title, descriptionmodel from ' . _DB_PREFIX_ . 'productmodel where active = false';
        $rows = Db :: getInstance(_PS_USE_SQL_SLAVE_)->ExecuteS($sql);
        $this->context->smarty->assign('products', $rows);
        $this->setTemplate('valid.tpl');
        if ($_SERVER['REQUEST_METHOD'] == 'POST') {
            foreach($rows as $key=>$row){
                if(Tools :: getValue('active_'.$row['id_productmodel'], false)){
                    Db :: getInstance()->update('productmodel', array('active'=>true), 'id_productmodel='.$row['id_productmodel']);
                    
                }
            }
            $link = new Link();
            Tools :: redirectAdmin($this->context->link->getAdminLink('AdminProductAddValid')); 
        }
        
    }
    
}