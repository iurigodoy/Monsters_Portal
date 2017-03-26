<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


          </div><!-- / -->
        </div><!-- /right_col -->
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            MonstersPortal - Desenvolvido por <a href="">Monsters Portal</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div><!-- /main_container -->
    </div><!-- /container body -->
    

    <!-- jQuery -->
    <script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../resources/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../resources/vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="../resources/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- Dropzone.js -->
    <script src="../resources/vendors/dropzone/dist/min/dropzone.min.js"></script>
    <!-- iCheck -->
    <script src="../resources/vendors/iCheck/icheck.min.js"></script>
    <!-- Flot -->
    <script src="../resources/vendors/Flot/jquery.flot.js"></script>
    <script src="../resources/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="../resources/vendors/Flot/jquery.flot.time.js"></script>
    <script src="../resources/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="../resources/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="../resources/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="../resources/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="../resources/vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../resources/vendors/moment/min/moment.min.js"></script>
    <script src="../resources/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="../resources/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
    <script src="../resources/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
    <script src="../resources/vendors/google-code-prettify/src/prettify.js"></script>
    <!-- Switchery -->
    <script src="../resources/vendors/switchery/dist/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="../resources/vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="../resources/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
    <!-- Datatables -->
    <script src="../resources/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="../resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="../resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="../resources/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="../resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="../resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="../resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <!-- <script src="../resources/vendors/datatables.net-scroller/js/datatables.scroller.min.js"></script> -->
    <script src="../resources/vendors/jszip/dist/jszip.min.js"></script>
    <script src="../resources/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../resources/vendors/pdfmake/build/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../resources/build/js/custom.min.js"></script>

    <!-- Autosize 
    <script>
      $(document).ready(function() {
        autosize($('.resizable_textarea'));
      });
    </script>
    <!-- /Autosize -->
    
    <!-- Datatables -->
    
    <!-- Produto -->
    <script>
      $(document).ready(function() {
        $('#datatable-descricao').DataTable();
        $('#datatable-promocional').DataTable();
        $('#datatable-descTec').DataTable();
        $('#datatable-otherInfo').DataTable();
      });
    </script>
    
    <!-- Clientes -->
    <script>
      $(document).ready(function() {
        $('#datatable-fisica').DataTable();
        $('#datatable-juridica').DataTable();
      });
    </script>
    
    <!-- Pedidos -->
    <script>
      $(document).ready(function() {
        $('#datatable-todos').DataTable();
      });
    </script>
    
    <!-- Funcionarios -->
    <script>
      $(document).ready(function() {
        $('#datatable-info').DataTable();
        $('#datatable-local').DataTable();
      });
    </script>
    
    <!-- Fornecedor -->
    <script>
      $(document).ready(function() {
        //$('#datatable-descricao').DataTable();
        $('#datatable-contato').DataTable();
        $('#datatable-local').DataTable();
      });
    </script>
    
    
  </body>
</html>