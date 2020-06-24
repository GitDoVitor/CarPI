import './login.scss'
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import {createMuiTheme, makeStyles, ThemeProvider} from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import {NavLink} from 'react-router-dom';
import {grey} from '@material-ui/core/colors';
import Imagem from '../../img/foda-min.png';


const tema = createMuiTheme({
  palette: {
    primary: { main: grey[900] }
  }
});

const useStyles = makeStyles(theme => ({
  paper: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  form: {
    width: '100%', // Fix IE 11 issue.
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

export default function SignIn() {  
  const classes = useStyles();

  return (
    
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
          <a href="/"><img alt="logo" src={ Imagem } id="logo"/></a>
        <form className={classes.form} noValidate>
        <ThemeProvider theme={ tema }>
          <TextField required margin="normal" fullWidth id="email" label="Endereço de Email" name="email" autoFocus />
          <TextField margin="normal" required fullWidth name="password" label="Senha" type="password" id="password" />
          <FormControlLabel control={<Checkbox value="remember" color="primary" />} label="Lembrar-me" id="remember" />
        </ThemeProvider>
          <Button type="submit" fullWidth variant="contained" color="primary" className={classes.submit} id="botola">Entrar</Button>
          <Grid container>
            <Grid item xs>
              <Link href="#" variant="body2" id="botolaco">Esqueceu a Senha?</Link>
            </Grid>
            <Grid item>
              <NavLink to="/cadastro" id='xesque'>Não Possui Conta?</NavLink>
            </Grid>
          </Grid>
        </form>
      </div>
      <Box mt={8}>
      </Box>
    </Container>
  );
}
